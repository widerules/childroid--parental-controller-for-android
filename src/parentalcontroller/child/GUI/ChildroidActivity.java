package parentalcontroller.child.GUI;

import parentalcontroller.child.R;
import parentalcontroller.child.Logic.GetInstallApplicationService;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ChildroidActivity extends Activity{
	private Button btmain;
	private Button btmsg;
	private Button btemail;
	private Button btmap;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btmain = (Button) findViewById(R.id.buttonMain);
		btmain.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
//				Intent i = new Intent(ChildroidActivity.this,
//						MapViewActivity.class);
//				startActivity(i);
				Intent intent = new Intent(ChildroidActivity.this, GetInstallApplicationService.class);
				startService(intent);
			}
		});

		this.btmsg = (Button) findViewById(R.id.showmsgbutton);
		this.btmsg.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent l = new Intent(ChildroidActivity.this,
						SMSSendActivity.class);
				startActivity(l);
			}
		});
		
		this.btemail = (Button) findViewById(R.id.bSendMail);
		this.btemail.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				
				Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);  
				  
				String aEmailList[] = { "ak47gc@gmail.com","jayani2010@gmail.com" };  
				String aEmailCCList[] = { "ak47gc@gmail.com","jayani2010@gmail.com"};  
				String aEmailBCCList[] = { "ak47gc@gmail.com","jayani2010@gmail.com" };  
				  
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);  
				emailIntent.putExtra(android.content.Intent.EXTRA_CC, aEmailCCList);  
				emailIntent.putExtra(android.content.Intent.EXTRA_BCC, aEmailBCCList);  
				  
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My subject");  
				  
				emailIntent.setType("plain/text");  
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "My message body.");  
				  
				startActivity(emailIntent); 
				
				/*final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                
                emailIntent.setType("plain/text");
           
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{ "ak47gc@gmail.com","jayani2010@gmail.com"});
         
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Test msg");
         
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hurray, its working....");
 
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));*/
			}
		});
		
		this.btmap = (Button) findViewById(R.id.buttonShowMap);
		this.btmap.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent l = new Intent(ChildroidActivity.this,
						MapViewActivity.class);
				startActivity(l);
				
				//startService(new Intent(getBaseContext(), MyService.class));
								
				Log.d("gihan", "clicked map show");

			}
		});
	}
}