package parentalcontroller.child.Logic;

import parentalcontroller.child.GUI.SMSReceiveActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SMSReceiveService extends BroadcastReceiver {

	private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

	@Override
	public void onReceive(Context context, Intent intent) {

		if (intent.getAction().equals(SMS_RECEIVED)) {

			Bundle bundle = intent.getExtras();
			if (bundle != null && bundle.containsKey("pdus")) {
				Object[] pdusObj = (Object[]) bundle.get("pdus");
				SmsMessage[] messages = new SmsMessage[pdusObj.length];

				// getting SMS information from Pdu
				for (int i = 0; i < pdusObj.length; i++) {
					messages[i] = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
				}
				Intent i = new Intent(context, SMSReceiveActivity.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

				String[] a = new String[10];
				int c = 0;
				for (SmsMessage currentMessage : messages) {
					String displayOriginatingAddress = currentMessage
							.getDisplayOriginatingAddress(); // has sender's
																// phone number
					String displayMessageBody = currentMessage
							.getDisplayMessageBody(); // has the actual message
					a[c] = displayOriginatingAddress + ":" + displayMessageBody;
					c++;
				}
				i.putExtra("msgset", a);
				context.startActivity(i);
			}
		}
	}
}
