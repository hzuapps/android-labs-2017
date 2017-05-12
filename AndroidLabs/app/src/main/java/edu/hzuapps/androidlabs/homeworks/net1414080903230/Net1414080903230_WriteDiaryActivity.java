package edu.hzuapps.androidlabs.homework.net1414080903230;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Net1414080903230_WriteDiaryActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903230__write_diary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void click(View view){
        //get the diary string
        TextView diary = (TextView) findViewById(R.id.atm_diary_content);
        String diaryContent = diary.getText().toString();

        //open the diarydata fold
        //File yygypath = this.getFilesDir();
        File sdpath = Environment.getExternalStorageDirectory();
        //get the time and it will become the diary_name at this time
        SimpleDateFormat    sDateFormat    =   new    SimpleDateFormat("yyyyMMddhhmmss");
        String    date    =    sDateFormat.format(new    java.util.Date());
        //add
        //if(dir.exists()&&dir.canWrite()){
            try {
                File dir = new File(sdpath,"diarydata");
                if(!dir.exists()){
                    Log.d("file2",dir.getAbsolutePath());
                    dir.mkdirs();
                }

                File newfile = new File(dir,date+".txt");
                FileOutputStream out = new FileOutputStream(newfile);
                //newfile.createNewFile();
                //out = openFileOutput(dir.getAbsolutePath() + "/" + date+".txt", Context.MODE_PRIVATE);
                //out = openFileOutput(newfile, Context.MODE_PRIVATE);
                sDateFormat = new    SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
                date = sDateFormat.format(new    java.util.Date());
                date += "\n";
                diaryContent += date;
                out.write(diaryContent.getBytes("UTF-8"));
                out.close();
                final File[] files = dir.listFiles();
                Log.d("file",Integer.toString(files.length));
            }catch(Exception e){
                e.printStackTrace();
            }

       //}
        Log.d("test","test");
        Intent intent = new Intent(this,Net414080903230_MainActivity.class);
        startActivity(intent);

    }

}
