package com.example.demo.cmp.calculate_percentage;

import java.util.List;

/**
 * @ClassName CaculateContext
 * @Description
 * @Author DaHuangGo
 * @Date 2023/12/1 16:15
 * @Version 0.0.1
 **/
public class CaculateContext {
    private List<Float> allHigher;
    private List<Float> allLower;
    private boolean isSuccess=false;

    public CaculateContext(List<Float> allHigher, List<Float> allLower) {
        this.allHigher = allHigher;
        this.allLower = allLower;
    }

    public CaculateContext() {
    }

    public List<Float> getAllHigher() {
        return allHigher;
    }

    public void setAllHigher(List<Float> allHigher) {
        this.allHigher = allHigher;
    }

    public List<Float> getAllLower() {
        return allLower;
    }

    public void setAllLower(List<Float> allLower) {
        this.allLower = allLower;
    }


    public boolean isSuccess() {
        return isSuccess;
    }

    private void setSuccess(boolean success) {
        isSuccess = success;
    }

    public void reset(){
        setSuccess(false);
    }

    public void success(){
        setSuccess(true);
    }
}
