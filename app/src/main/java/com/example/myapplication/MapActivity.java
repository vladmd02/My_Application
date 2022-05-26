package com.example.myapplication;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.hm;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity {

    private static  int MAX_MESSAGE_LENGTH = 100;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("messages");

    EditText mEditTextMessage;
    Button mSendButton;
    RecyclerView mMessagesRecycler;

    ArrayList<String> messages = new ArrayList<>();

    Button btnSignIn , btnRegister;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    LinearLayout root ;

//    hm shifr = new hm();
//    public static int key = 0;
//    vigenere.Vigenere();// message - " Parola Mea " ;  key - " BEC "

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = findViewById(R.id.SIGN);
        btnRegister = findViewById(R.id.REG);

        root = findViewById(R.id.root_element);
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        mSendButton = findViewById(R.id.send_message_b);
        mEditTextMessage = findViewById(R.id.message_input);
        mMessagesRecycler = findViewById(R.id.message_recycler);

        mMessagesRecycler.setLayoutManager( new LinearLayoutManager(this));

        DataAdapter dataAdapter = new DataAdapter(this , messages );
        mMessagesRecycler.setAdapter(dataAdapter);

        mSendButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = mEditTextMessage.getText().toString();
//                switch (key) {
//                    case 1:
//                       // key = 1;
//                        break;
//                    case 2:
//                        msg = shifr.vigenere(msg);
//                        System.out.println(msg);
//                        break;
//                    case 3:
//                        break;
//                    case 4:
//                        break;
//                }
                if (msg.equals("")) {
                    Toast.makeText(getApplicationContext(), "Введите сообщение !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (msg.length() == MAX_MESSAGE_LENGTH) {
                    Toast.makeText(getApplicationContext(), "Слишком длинное сообщение ! ", Toast.LENGTH_SHORT).show();
                    return;
                }
                myRef.push().setValue(msg);
                mEditTextMessage.setText("");
            }
        });

        myRef.addChildEventListener( new ChildEventListener() {
            @Override
            public void onChildAdded( DataSnapshot dataSnapshot ,  String s) {
                String msg = dataSnapshot.getValue(String.class);
//                switch( MapActivity.key ) {
//                    case 1:
//                        break;
//                    case 2:
//                        msg = shifr.DE_Vigenere(msg);
//                        break;
//                }
                messages.add(msg);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Button button = findViewById(R.id.button);

        button.setOnClickListener(viewClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // TextView headerView = findViewById(R.id.main);
        switch(id){
            case R.id.item1 :
                messages.clear();
                return true;
           // case R.id.item2:
            //    return true;
//            case R.id.item3:
//                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    View.OnClickListener viewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showPopupMenu(v);
        }
    };

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.popupmenu);

        popupMenu
                .setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu1:
                               // key = 1;
                                Toast.makeText(getApplicationContext(), "Вы выбрали RSA-шифрование", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.menu2:
                               // key = 2;
                                Toast.makeText(getApplicationContext(), "Вы выбрали Шифр Виженера", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.menu3:
                               // key = 3;
                                Toast.makeText(getApplicationContext(), "Вы выбрали Шифр Вернама", Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });

        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
                Toast.makeText(getApplicationContext(), "onDismiss",
                        Toast.LENGTH_SHORT).show();
            }
        });
        popupMenu.show();
    }
}



