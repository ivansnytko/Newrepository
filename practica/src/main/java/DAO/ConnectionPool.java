package DAO;

import java.sql.Connection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;

public class ConnectionPool {
	private static ConnectionPool instance;
	private static int maxPoolSize;
	private String userName;
	private String password;
	private String path;
	private String className;
	private static Logger log = Logger.getLogger("dbpool");
	// connection storage
	private ConcurrentLinkedQueue<Connection> connections;
	private boolean alreadyInitialized = false;	
	
	public ConnectionPool() {
		connections = new ConcurrentLinkedQueue<Connection>();
	}

	public static ConnectionPool getInstance() {
		if (instance == null)
			instance = new ConnectionPool();
		return instance;
	}
	
	public static int getMaxPoolSize()
	{
		return maxPoolSize;
		
	} 

	public static Connection getConnection() {
		return getInstance().getInstanceConnection();
	}

	public static void releaseConnection(Connection c) {
		getInstance().releaseInstanceConnection(c);
	}

	/**
	 * Get connection from pool check validation, kill dead, if can't make new
	 * connection just log
	 */

	private Connection getInstanceConnection() {
		if (!alreadyInitialized) {
			log.severe("improper using of db pool (getConnection without init)");
			return null;
		}
		;
		Connection currentConnection;
		do {
			currentConnection = connections.poll();

			if (currentConnection == null)
				break; // empty pool
			// doesn't use dead connection
			if (!validConnection(currentConnection)) {
				currentConnection = null;
			}
		} while (currentConnection == null);

		try {
			if (connections.size() == 0) {
				log.info("DB Pool depleted, add new connection");
				connections.add(java.sql.DriverManager.getConnection(path,
						userName, password));
				currentConnection = connections.poll();
				if (!validConnection(currentConnection)) {
					// white flag
					throw new Exception("new connection also is not valid");
				}
			}
		} catch (Exception ie) {

			log.severe("cannot provide sql connection:" + ie);
			return null;
		}
		;
		return currentConnection;
	}

	private void releaseInstanceConnection(Connection c) {
		if (!alreadyInitialized) {
			log.severe("improper using of db pool (releseConnection without init)");
			return;
		}
		;
		if (getCurrentSize() >= getMaxPoolSize()) {
			try {
				c.close();
			} catch (Exception e) {
			}
			;
		} else if (!validConnection(c)) {
		} else {
			connections.offer(c);
		}
	}

/*	public int getMaxPoolSize() {
		return maxPoolSize;
	} */

	public void setPoolsize(int maxPoolSize) {
		if (!alreadyInitialized) {
			this.maxPoolSize = maxPoolSize;
		} else {
			log.severe("setPoolsize after init. ignoring");
		}
	} 

	public int getCurrentSize() {
		return connections.size();
	}

	public String getUserName() {
		return userName;
	}

	public void setUsername(String userName) {
		if (!alreadyInitialized) {
			this.userName = userName;
		} else {
			log.severe("setUserName after init. ignoring");
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (!alreadyInitialized) {
			this.password = password;
		} else {
			log.severe("setPassword after init. ignoring");
		}
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		if (!alreadyInitialized) {
			this.path = path;
		} else {
			log.severe("Path after init. ignoring");
		}
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		if (!alreadyInitialized) {
			this.className = className;
		} else {
			log.severe("setClassName after init. ignoring");
		}
	}

	/**
	 * init - initialization
	 * 
	 * @return boolean - if pool initialized successful return true
	 */

	public synchronized boolean init() {
		log.entering("ConnectionPool", "init");
		try {
			if (alreadyInitialized) {
				throw new Exception("Double init of db pool");
			}

			Class.forName(this.className);
			for (int i = 1; i <= 12; i++) {
				connections.add(java.sql.DriverManager.getConnection(path,
						userName, password));
			}
			;
			alreadyInitialized = true;
			log.exiting("ConnectionPool", "init");
			return true;
		} catch (Exception e) {
			log.severe("Cannot init db pool:" + e);
		}

		log.exiting("ConnectionPool", "init");
		return false;
	}

	private boolean validConnection(java.sql.Connection c) {
		try {
			boolean status = c.getAutoCommit();
			c.setAutoCommit(!status);
			c.setAutoCommit(status);
		} catch (Exception e) {
			try {
				c.close();
			} catch (Exception notImportant) {
			}
			;
			log.info("Dead sql connection detected");
			return false;
		}
		return true;
	}
}