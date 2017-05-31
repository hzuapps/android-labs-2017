package homeworks.androids.hzuapps.edu.application.net1414080903219;

/**
 * Created by mary on 2017/5/5.
 */

public class Word {
    public String english, mean, status;

    public Word(String english,String mean,String status){
        this.english=english;
        this.mean=mean;
        this.status=status;
    }

    public String getEnglish(){
        return english;
    }

    public String getMean(){
        return mean;
    }

    public String getStatus(){
        return status;
    }
}
