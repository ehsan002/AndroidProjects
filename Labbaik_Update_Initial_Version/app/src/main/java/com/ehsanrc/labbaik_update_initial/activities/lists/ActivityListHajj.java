package com.ehsanrc.labbaik_update_initial.activities.lists;

/**
 * Created by USER on 12/06/2016.
 */
public class ActivityListHajj {

    private int id;
    private String activityName;
    private int image;

    public ActivityListHajj() {
    }

    public ActivityListHajj(String activityName, int image) {

        this.activityName = activityName;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
