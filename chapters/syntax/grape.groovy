@Grapes([
    @Grab('org.slf4j:slf4j-simple:1.5.11'),
    @Grab('com.h2database:h2:1.3.148'),
    @GrabConfig(systemClassLoader = true)
])
import org.slf4j.*
import groovy.sql.*

def logger = LoggerFactory.getLogger('sql')

logger.info 'Initialize SQL'

// Sql.newInstance needs to look into the System classloader with
// Class.forName(...) instead of the
// Groovy script classloader for the org.h2.Driver class.
def sql = Sql.newInstance('jdbc:h2:mem:test', 'sa', '', 'org.h2.Driver')

assert sql

logger.info "Got a SQL connection: $sql"

// Logger output:
// 7 [main] INFO sql - Initialize SQL
// 346 [main] INFO sql - Got a SQL connection:
