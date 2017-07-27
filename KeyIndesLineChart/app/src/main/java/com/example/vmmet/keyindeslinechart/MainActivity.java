package com.example.vmmet.keyindeslinechart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
private KeyIndexLineChart lineChart1,lineChart2;
    private keyIndexLinebean keyIndexLinebean1,keyIndexLinebean2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lineChart1=(KeyIndexLineChart)findViewById(R.id.linechart1);
        lineChart2=(KeyIndexLineChart)findViewById(R.id.linechart2);
        initdata();
        lineChart1.setDateSource(keyIndexLinebean1);
        lineChart2.setDateSource(keyIndexLinebean2);
    }

    private void initdata() {
        keyIndexLinebean1=new keyIndexLinebean();
        keyIndexLinebean1.setKeyindexname("功率曲线");
        keyIndexLinebean1.setNowname("发电功率(昨天)");
        keyIndexLinebean1.setLastname("发电功率(当天)");
        List<String> x_numbers=new ArrayList<>();
        String xx[]={"00:00","03:00","06:00","09:00","12:00","15:00","18:00","21:00","24:00"};
        for (String s:xx){
            x_numbers.add(s);
        }
        keyIndexLinebean1.setX_numbers(x_numbers);
        List<String> y_numbers=new ArrayList<>();
        String yy[]={"45000","55000","65000","75000","85000","95000"};
        for (String s:yy){
            y_numbers.add(s);
        }
        keyIndexLinebean1.setY_numbers(y_numbers);
        int max=95000;
        int min=45000;
        keyIndexLinebean1.setMax(max);
        keyIndexLinebean1.setMin(min);
        List<Float> now_numbers=new ArrayList<>();
        List<Float> last_numbers=new ArrayList<>();
        Random random = new Random();
        for (int i=0;i<25;i++){
            float a=random.nextInt(65000)%(20000+1) + 65000;
            float b=random.nextInt(65000)%(20000+1) + 65000;
            now_numbers.add(a);
            last_numbers.add(b);
        }
        keyIndexLinebean1.setX_datas(25);
        keyIndexLinebean1.setNow_numbers(now_numbers);
        keyIndexLinebean1.setLast_numbers(last_numbers);

        keyIndexLinebean2=new keyIndexLinebean();
        keyIndexLinebean2.setX_datas(12);
        keyIndexLinebean2.setKeyindexname("发电量对比");
        keyIndexLinebean2.setNowname("发电量(今年)");
        keyIndexLinebean2.setLastname("发电量(去年)");
        List<String> x_numbers2=new ArrayList<>();
        String xx2[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
        for (String s:xx2){
            x_numbers2.add(s);
        }
        keyIndexLinebean2.setX_numbers(x_numbers2);
        List<String> y_numbers2=new ArrayList<>();
        String yy2[]={"10","12","14","16","18","20"};
        for (String s:yy2){
            y_numbers2.add(s);
        }
        keyIndexLinebean2.setY_numbers(y_numbers2);
        int max2=20;
        int min2=10;
        keyIndexLinebean2.setMax(max2);
        keyIndexLinebean2.setMin(min2);
        List<Float> now_numbers2=new ArrayList<>();
        List<Float> last_numbers2=new ArrayList<>();
        Random random2 = new Random();
        for (int i=0;i<12;i++){
            float a=random2.nextInt(18)%(4+1) + 14;
            float b=random2.nextInt(18)%(4+1) + 14;
            now_numbers2.add(a);
            last_numbers2.add(b);
        }
        keyIndexLinebean2.setNow_numbers(now_numbers2);
        keyIndexLinebean2.setLast_numbers(last_numbers2);
    }
}
