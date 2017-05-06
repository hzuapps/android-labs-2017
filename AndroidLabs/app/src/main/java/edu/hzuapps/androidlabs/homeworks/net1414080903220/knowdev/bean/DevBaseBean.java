package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.bean;

import java.io.Serializable;
import java.util.List;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.bean
 * Class describe:
 * Author: cheng
 * Create time: 2017/5/6 11:16
 */
public class DevBaseBean implements Serializable {
    private boolean error;
    private List<DevArticle> results;
    public void setError(boolean error) {
        this.error = error;
    }
    public boolean getError() {
        return error;
    }

    public void setResults(List<DevArticle> results) {
        this.results = results;
    }
    public List<DevArticle> getResults() {
        return results;
    }
}
