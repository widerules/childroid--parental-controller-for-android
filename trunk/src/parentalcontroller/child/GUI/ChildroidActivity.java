package parentalcontroller.child.GUI;

import parentalcontroller.child.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChildroidActivity extends Activity {
	private Button btmain;
	private Button btmsg;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btmain = (Button) findViewById(R.id.buttonMain);
        btmain.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
           Intent i = new Intent(ChildroidActivity.this, SMSReceiveActivity.class);
           startActivity(i);
           }
        });
        
        this.btmsg = (Button) findViewById(R.id.showmsgbutton);
        this.btmsg.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
           Intent l = new Intent(ChildroidActivity.this, SMSSendActivity.class);
           startActivity(l);
           }
        });
    }
}