package com.unicom.netty809.config;

import com.unicom.netty809.util.db.DbUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

/**
 * @Desc: 数据源
 * @author:zhengs
 * @Time: 18-12-29 上午9:03
 * @Copyright: ©  杭州凯立通信有限公司 版权所有
 * @Warning: 本内容仅限于公司内部传阅,禁止外泄或用于其它商业目的
 */
@Component
public class DruidDataSource {
	/**
	 * 日志对象
	 */
	private static final Logger logger = LogManager.getLogger();

	/**
	 * 数据库驱动
	 */
	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;

	/**
	 * 数据库连接url
	 */
	@Value("${spring.datasource.url}")
	private String url;

	/**
	 * 数据库连接用户名
	 */
	@Value("${spring.datasource.username}")
	private String username;

	/**
	 * 数据库连接密码
	 */
	@Value("${spring.datasource.password}")
	private String password;

	/**
	 * 初始化连接池大小
	 */
	@Value("${spring.datasource.initialSize}")
	private Integer initialSize;

	/**
	 * 最大连连接池大小
	 */
	@Value("${spring.datasource.maxActive}")
	private Integer maxActive;

	/**
	 * 连接池最少空闲连接数
	 */
	@Value("${spring.datasource.minIdle}")
	private Integer minIdle;

	/**
	 * 获取连接等待超时的时间
	 */
	@Value("${spring.datasource.maxWait}")
	private Integer maxWait;

	/**
	 * 打开PSCache
	 */
	@Value("${spring.datasource.poolPreparedStatements}")
	private boolean poolPreparedStatements;

	/**
	 * 指定每个连接上PSCache的大小
	 */
	@Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
	private Integer maxPoolPreparedStatementPerConnectionSize;

	/**
	 *检测连接是否有效SQL
	 */
	@Value("${spring.datasource.validationQuery}")
	private String validationQuery;

	/**
	 *检测连接是否有效SQL-超时时间
	 */
	@Value("${spring.datasource.validationQueryTimeout}")
	private Integer validationQueryTimeout;

	/**
	 *申请连接时执行SQL检测是否有效,配置为true时回降低性能
	 */
	@Value("${spring.datasource.testOnBorrow}")
	private boolean testOnBorrow;

	/**
	 *归还连接时执行SQL检测是否有效,配置为true时回降低性能
	 */
	@Value("${spring.datasource.testOnReturn}")
	private boolean testOnReturn;

	/**
	 *建议配置为true,不影响性能,申请连接的时候检测,如果空闲时间大于timeBetweenEvictionRunsMillis,执行validationQuery检测是否有效
	 */
	@Value("${spring.datasource.testWhileIdle}")
	private boolean testWhileIdle;

	/**
	 *配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
	 */
	@Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
	private Integer timeBetweenEvictionRunsMillis;

	/**
	 *配置一个连接在池中最小生存的时间，单位是毫秒
	 */
	@Value("${spring.datasource.minEvictableIdleTimeMillis}")
	private Integer minEvictableIdleTimeMillis;

	/**
	 *超过时间限制是否回收
	 */
	@Value("${spring.datasource.removeAbandoned}")
	private boolean removeAbandoned;

	/**
	 *超时时间,单为为秒
	 */
	@Value("${spring.datasource.removeAbandonedTimeout}")
	private Integer removeAbandonedTimeout;

	/**
	 * 关闭abanded连接时输出错误日志
	 */
	@Value("${spring.datasource.logAbandoned}")
	private boolean logAbandoned;

	/**
	 *通过别名的方式配置扩展插件
	 */
	@Value("${spring.datasource.filters}")
	private String filters;

	/**
	* 数据源
	*/
	private DataSource dataSource;

	/**
	* 获取数据源
	* @author:zhengs
	* @Time: 19-3-1 下午2:02
	*
	* @return
	*/
	public DataSource getDataSource(){
		synchronized (DruidDataSource.class){
			if(this.dataSource == null){
				this.dataSource = createAtomsDataSource();
			}
		}

		return this.dataSource;
	}

	/**
	 * 创建数据源
	 * @return
	 * @throws Exception
	 */
    public DataSource createAtomsDataSource() {
		AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
		ds.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
		ds.setUniqueResourceName("default");
		ds.setMinPoolSize(initialSize);
		ds.setMaxPoolSize(maxActive);
		ds.setMaxLifetime(20000);
		try{
			ds.setLoginTimeout(30);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		ds.setTestQuery(validationQuery);
		ds.setXaProperties(initProperties());

		return ds;
    }

    public Properties initProperties(){
		Properties prop = new Properties();
		prop.put("url", url);
		prop.put("username", username);
		prop.put("password", password);
		prop.put("driverClassName", driverClassName);
		prop.put("initialSize", initialSize);
		prop.put("maxActive", maxActive);
		prop.put("minIdle", minIdle);
		prop.put("maxWait", maxWait);
		prop.put("poolPreparedStatements", poolPreparedStatements);
		prop.put("maxPoolPreparedStatementPerConnectionSize",maxPoolPreparedStatementPerConnectionSize);
		prop.put("validationQuery", validationQuery);
		prop.put("validationQueryTimeout", validationQueryTimeout);
		prop.put("testOnBorrow", testOnBorrow);
		prop.put("testOnReturn", testOnReturn);
		prop.put("testWhileIdle", testWhileIdle);
		prop.put("timeBetweenEvictionRunsMillis",timeBetweenEvictionRunsMillis);
		prop.put("minEvictableIdleTimeMillis",minEvictableIdleTimeMillis);
		prop.put("removeAbandoned",removeAbandoned);
		prop.put("removeAbandonedTimeout",removeAbandonedTimeout);
		prop.put("logAbandoned",logAbandoned);
		prop.put("filters", filters);
        prop.put("connectionProperties", "config.decrypt=true;publickey="+DbUtil.DRUID_PUBLIC_KEY +";password="+password);
        prop.put("passwordCallbackClassName", DbUtil.DRUID_PASSWORD_CALLBACK);
		return prop;
	}

	/**
	 * 根据租户ID获取数据源
	 * @param collectionId
	 * @return
	 * @throws Exception
	 */
	public DataSource getDataSourceFromDB(String key) {
		if(key == null){
			return null;
		}
		Properties props = null;
		AtomikosDataSourceBean ds = null;
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "select driver_class_name,url,username,password,id from t_sys_datasource where status=1 and data_source_name=?";
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, DbUtil.druidDecrypt(password));
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,key);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				ds = new AtomikosDataSourceBean();

				props = initProperties();
				props.put("driverClassName", rs.getString(1));
				props.put("url", rs.getString(2));
				props.put("username", rs.getString(3));
				props.put("password", rs.getString(4));
				props.put("connectionProperties", "config.decrypt=true;publickey="+DbUtil.DRUID_PUBLIC_KEY +";password="+rs.getString(4));

				ds.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
				ds.setUniqueResourceName(key);
				ds.setMinPoolSize(initialSize);
				ds.setMaxPoolSize(maxActive);
				ds.setMaxLifetime(20000);
				try{
					ds.setLoginTimeout(30);
				}catch(Exception e){
					logger.error(e.getMessage(),e);
				}
				ds.setTestQuery(validationQuery);
				ds.setXaProperties(props);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pStmt != null) {
				try {
					pStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return ds;
	}
}
