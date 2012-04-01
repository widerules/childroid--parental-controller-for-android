package parentalcontroller.child.GUI;

import parentalcontroller.child.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChildroidActivity extends Activity {
	private Button btmain;
	private Button btmsg;
	private Button btemail;
	private Button btmap;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		/*
		 * show the mail default botton
		 */
		btmain = (Button) findViewById(R.id.buttonMain);
		btmain.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				// Intent i = new Intent(ChildroidActivity.this,
				// MapViewActivity.class);
				// startActivity(i);
				// Intent intent = new Intent(ChildroidActivity.this,
				// DeviceAdmin.class);
				// startService(intent);
				Toast.makeText(getBaseContext(),
						"The custom preference has been clicked",
						Toast.LENGTH_LONG).show();

				authenticate();				
			}
		});
		/*
		 * send the msg to parentdroid
		 */
		this.btmsg = (Button) findViewById(R.id.showmsgbutton);
		this.btmsg.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent l = new Intent(ChildroidActivity.this,
						SMSSendActivity.class);
				startActivity(l);
			}
		});

		/*
		 * send email to the parentdroid
		 */
		this.btemail = (Button) findViewById(R.id.bSendMail);
		this.btemail.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {

				Intent emailIntent = new Intent(
						android.content.Intent.ACTION_SEND);

				String aEmailList[] = { "ak47gc@gmail.com",
						"jayani2010@gmail.com" };
				String aEmailCCList[] = { "ak47gc@gmail.com",
						"jayani2010@gmail.com" };
				String aEmailBCCList[] = { "ak47gc@gmail.com",
						"jayani2010@gmail.com" };

				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
						aEmailList);
				emailIntent.putExtra(android.content.Intent.EXTRA_CC,
						aEmailCCList);
				emailIntent.putExtra(android.content.Intent.EXTRA_BCC,
						aEmailBCCList);

				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
						"My subject by Gihan");

				emailIntent.setType("plain/text");
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
						"My message body by Gihan.");

				startActivity(emailIntent);

				/*
				 * final Intent emailIntent = new
				 * Intent(android.content.Intent.ACTION_SEND);
				 * 
				 * emailIntent.setType("plain/text");
				 * 
				 * emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new
				 * String[]{ "ak47gc@gmail.com","jayani2010@gmail.com"});
				 * 
				 * emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
				 * "Test msg");
				 * 
				 * emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
				 * "Hurray, its working....");
				 * 
				 * startActivity(Intent.createChooser(emailIntent,
				 * "Send mail..."));
				 */
			}
		});

		/*
		 * show the map location of childroid
		 */
		this.btmap = (Button) findViewById(R.id.buttonShowMap);
		this.btmap.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent l = new Intent(ChildroidActivity.this,
						MapViewActivity.class);
				startActivity(l);

				// startService(new Intent(getBaseContext(), MyService.class));

				Log.d("gihan", "clicked map show");

			}
		});
	}

	private boolean authenticate() {
		final Context context = this;
		boolean isAdmin = false;
		
		// get prompts.xml view
		LayoutInflater li = LayoutInflater.from(context);
		View promptsView = li.inflate(R.layout.loginlayout, null);

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);

		// set prompts.xml to alertdialog builder
		alertDialogBuilder.setView(promptsView);

		final EditText username = (EditText) promptsView.findViewById(R.id.txusername);
		final EditText password = (EditText) promptsView.findViewById(R.id.txpassword);

		// set dialog message
		alertDialogBuilder
				.setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// get user input and set it to result
						// edit text
						//result.setText(userInput.getText());
						Log.d("authentication", username.getText().toString());
						Log.d("authentication", password.getText().toString());
						
						Intent settingsActivity = new Intent(getBaseContext(),
								DeviceAdmin.class);
						startActivity(settingsActivity);
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();

		return isAdmin;
	}
	private void getPrefs() {
		boolean CheckboxPreference;
        String ListPreference;
        String editTextPreference;
        String ringtonePreference;
        String secondEditTextPreference;
        String customPref;
        // Get the xml/preferences.xml preferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        
        CheckboxPreference = prefs.getBoolean("checkboxPref", true);
        ListPreference = prefs.getString("listPref", "nr1");
        editTextPreference = prefs.getString("editTextPref",
                        "Nothing has been entered");
        ringtonePreference = prefs.getString("ringtonePref",
                        "DEFAULT_RINGTONE_URI");
        secondEditTextPreference = prefs.getString("SecondEditTextPref",
                        "Nothing has been entered");
        // Get the custom preference
        SharedPreferences mySharedPreferences = getSharedPreferences(
                        "myCustomSharedPrefs", Activity.MODE_PRIVATE);
        customPref = mySharedPreferences.getString("myCusomPref", "");
}
	class LoginInof{
		private String username;
		private String password;
		
		public LoginInof(String name, String pass) {
			// TODO Auto-generated constructor stub
			this.username = name;
			this.password=pass;
		}
		
		protected String getUserName() {
			return this.username;
		}
		protected String getPassword() {
			return this.password;
		}
	}
}