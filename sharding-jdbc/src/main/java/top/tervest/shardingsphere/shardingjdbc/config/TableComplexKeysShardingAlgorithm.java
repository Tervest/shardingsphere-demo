package top.tervest.shardingsphere.shardingjdbc.config;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ZhangNanNan
 * @create 2019-08-13 11:52
 */
public class TableComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm<String> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ComplexKeysShardingValue<String> shardingValue) {
        Collection<String> list = new ArrayList<>();
        String db_name="DA_MEDICAL_HPT1";
        Map<String, Collection<String>> columnNameAndShardingValuesMap = shardingValue.getColumnNameAndShardingValuesMap();

        if (!Objects.isNull(columnNameAndShardingValuesMap)) {
            List<String> collect_time = (List)columnNameAndShardingValuesMap.get("COLLECT_TIME");
            String s = collect_time.get(0);
            try {
                Date date = (Date) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
                String year = String.format("%tY", date);
                db_name=db_name+"_"+year;
                list.add(db_name);
                System.out.println("db_name:" + db_name);

            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }
}
