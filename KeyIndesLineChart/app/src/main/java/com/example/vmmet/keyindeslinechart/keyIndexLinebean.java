package com.example.vmmet.keyindeslinechart;

import java.util.List;

/**
 * Created by Vmmet on 2016/10/12.
 */
public class keyIndexLinebean {
    private String nowname;
    private String lastname;
    private int x_datas;
    private String keyindexname;

    public String getKeyindexname() {
        return keyindexname;
    }

    public void setKeyindexname(String keyindexname) {
        this.keyindexname = keyindexname;
    }
    public int getX_datas() {
        return x_datas;
    }

    public void setX_datas(int x_datas) {
        this.x_datas = x_datas;
    }

    private List<String> x_numbers;
    private List<String> y_numbers;
    private List<Float> now_numbers;
    private List<Float> last_numbers;
    private float max;
    private float min;

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public String getNowname() {
        return nowname;
    }

    public void setNowname(String nowname) {
        this.nowname = nowname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<String> getX_numbers() {
        return x_numbers;
    }

    public void setX_numbers(List<String> x_numbers) {
        this.x_numbers = x_numbers;
    }

    public List<String> getY_numbers() {
        return y_numbers;
    }

    public void setY_numbers(List<String> y_numbers) {
        this.y_numbers = y_numbers;
    }

    public List<Float> getNow_numbers() {
        return now_numbers;
    }

    public void setNow_numbers(List<Float> now_numbers) {
        this.now_numbers = now_numbers;
    }

    public List<Float> getLast_numbers() {
        return last_numbers;
    }

    public void setLast_numbers(List<Float> last_numbers) {
        this.last_numbers = last_numbers;
    }
}
