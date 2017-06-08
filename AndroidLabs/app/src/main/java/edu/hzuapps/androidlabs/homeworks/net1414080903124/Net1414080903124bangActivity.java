package edu.hzuapps.androidlabs.homeworks.net1414080903124;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

import edu.hzuapps.androidlabs.R;

    public class Net1414080903124bangActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Net1414080903124Helper mNet1414080903124Helper;
    private Cursor mCursor;
    private EditText AccountName;
    private EditText AccountNumber;
    private ListView AccountsList;
    private int USER_ID = 0;
    protected final static int MENU_ADD = Menu.FIRST;
    protected final static int MENU_DELETE = Menu.FIRST + 1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903124bang);
        setUpViews();
    }

    public void setUpViews(){
        mNet1414080903124Helper = new Net1414080903124Helper(this);
        mCursor = mNet1414080903124Helper.select();

        AccountName = (EditText)findViewById(R.id.AccountName);
        AccountNumber = (EditText)findViewById(R.id.AccountNumber);
        AccountsList = (ListView)findViewById(R.id.AccountsList);
        AccountsList.setAdapter(new AccountListAdapterView(this, mCursor));
        AccountsList.setOnItemClickListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(Menu.NONE, MENU_ADD, 0, "ADD");
        menu.add(Menu.NONE, MENU_DELETE, 0, "DELETE");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case MENU_ADD:
                add();
                break;
            case MENU_DELETE:
                delete();
                break;

        }
        return true;
    }

    public void add(){
        String name = AccountName.getText().toString();
        String number = AccountNumber.getText().toString();
        if (AccountName.equals("") || number.equals("")){
            return;
        }
        mNet1414080903124Helper.insert(name, number);
        mCursor.requery();
        AccountsList.invalidateViews();
        AccountName.setText("");
        AccountNumber.setText("");
        Toast.makeText(this, "Add Successed!", Toast.LENGTH_SHORT).show();
    }

    public void delete(){
        if (USER_ID == 0) {
            return;
        }
        mNet1414080903124Helper.delete(USER_ID);
        mCursor.requery();
        AccountsList.invalidateViews();
        AccountName.setText("");
        AccountNumber.setText("");
        Toast.makeText(this, "Delete Successed!", Toast.LENGTH_SHORT).show();
    }


    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        mCursor.moveToPosition(position);
        USER_ID= mCursor.getInt(0);
        AccountName.setText(mCursor.getString(1));
        AccountNumber.setText(mCursor.getString(2));

    }

        public class AccountListAdapterView extends BaseAdapter{
        private Context mContext;
        private Cursor mCursor;
        public AccountListAdapterView(Context context,Cursor cursor) {

            mContext = context;
            mCursor = cursor;
        }
        @Override
        public int getCount() {
            return mCursor.getCount();
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView mTextView = new TextView(mContext);
            mCursor.moveToPosition(position);
            mTextView.setText(mCursor.getString(1) + "___" + mCursor.getString(2));
            return mTextView;
        }

    }
    }






