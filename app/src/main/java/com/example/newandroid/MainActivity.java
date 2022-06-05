package com.example.newandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText mIsbnEt = null;
    private Button mSearchBtn = null;
    private Button mAddBtn = null;
    private TextView mIsbnTxv = null;
    private ListView superListView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isbn);

        //get component
        mIsbnEt =findViewById(R.id.editText);
        mSearchBtn=findViewById(R.id.button);
        mIsbnTxv = findViewById(R.id.receivedView);
        superListView = findViewById(R.id.superListView);

        mAddBtn=findViewById(R.id.addButton);
        mAddBtn.setEnabled(false);
        //bind event
        mSearchBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //get isbn
                String isbn=mIsbnEt.getText().toString();
                // search
                if (!isbn.equals(""))
                    getISBN(isbn);
                else
                    getISBN("9787020024759");
                //display
                mIsbnTxv.setText(isbn);
            }
        });
        mAddBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "添加成功", Toast.LENGTH_LONG).show();
                mAddBtn.setEnabled(false);
            }
        });
    }
    private void getISBN(String follow) {
        String apikey = "?apikey=12798.be9fe12d765a837fc4e59f1889eebd35.99a9421d4921279f6aac7e533f5da6e3";
        Call<Results> call = RetrofitClient.getInstance().getMyApi().callAPI(follow+apikey);
        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                if (response.isSuccessful()) {
                    Results apiResult = response.body();
                    String[] bookInfos = new String[4];

                    if(apiResult.getMsg().equals("请求成功")) {
                        try {
                            bookInfos[0] = "书名：" + apiResult.getName();
                            bookInfos[1] = "作者：" + apiResult.getAuthor();
                            bookInfos[2] = "出版社：" + apiResult.getPublishing();
                            bookInfos[3] = "出版时间：" + apiResult.getPublishTime();
                            mAddBtn.setEnabled(true);

                        } catch(Exception e) {
                            bookInfos[0] = "请求失败：书目不存在";
                            for(int i=1;i<4;i++)
                                bookInfos[i]="";
                        }
                    }
                    else{
                        bookInfos[0] = "请求失败：" + apiResult.getMsg().split("详")[0];
                        for(int i=1;i<4;i++)
                            bookInfos[i]="";
                    }
                    superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, bookInfos));

                }
                else{
                    Toast.makeText(getApplicationContext(), "HTTP Error:"+response.code(), Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occurred", Toast.LENGTH_LONG).show();
            }

        });
    }
}