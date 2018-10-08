package csc315.com.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView taskList;
    EditText taskBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskList = (ListView)findViewById(R.id.taskList);
        taskBox = (EditText)findViewById(R.id.taskEntry);
    }

    public void addTask(View view) {
        DatabaseHandler dbHandler = new DatabaseHandler(this, null, null, 1);

        Task task = new Task(taskBox.getText().toString());

        dbHandler.addTask(task);
        taskBox.setText("");
    }
}


