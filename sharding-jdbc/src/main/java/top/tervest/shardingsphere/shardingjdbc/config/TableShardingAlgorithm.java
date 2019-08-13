package top.tervest.shardingsphere.shardingjdbc.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * @author ZhangNanNan
 * @create 2019-08-13 10:21
 */
public class TableShardingAlgorithm implements PreciseShardingAlgorithm<String> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {


        String db_name="DA_MEDICAL_HPT1";
        try {
            Date date = (Date) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(preciseShardingValue.getValue());

            String year = String.format("%tY", date);
            db_name=db_name+"_"+year;
            System.out.println("db_name:" + db_name);
            return db_name;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return db_name;
    }
}
