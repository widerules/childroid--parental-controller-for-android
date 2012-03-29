package parentalcontrol.parent.GUI;

import parentalcontrol.parent.GUI.LoginActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.TextView;

public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity> {

	private LoginActivity mActivity;
	private String resourceString;
	private TextView mView;

	public LoginActivityTest() {
		super("parentalcontrol.parent.GUI", LoginActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = this.getActivity();
		mView =  (TextView) mActivity).findViewById(parentalcontrol.parent.GUI.R.id.txusername);
		resourceString = mActivity.getString(parentalcontrol.parent.GUI.R.id.txpassword);
	}

	public void testPreconditions() {
		assertNotNull(mView);
	}

	public void testText() {
		assertEquals(resourceString, (String) mView.getText());
	}
}