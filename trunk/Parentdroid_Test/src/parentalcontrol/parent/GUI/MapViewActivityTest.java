package parentalcontrol.parent.GUI;

import parentalcontrol.parent.GUI.LoginActivity;
import parentalcontrol.parent.GUI.MapViewActivity;
import android.test.ActivityInstrumentationTestCase;
import android.widget.TextView;

public class MapViewActivityTest extends ActivityInstrumentationTestCase<MapViewActivity>{

	private LoginActivity mActivity;
	private String resourceString;
	private TextView mView;

	public LoginActivityTest() {
		super("parentalcontrol.parent.GUI", MapViewActivityTest.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = this.getActivity();
		mView = (TextView) mActivity.findViewById(parentalcontrol.parent.GUI.R.id.txusername);
		resourceString = mActivity.getString(parentalcontrol.parent.GUI.R.string.hello);
	}

	public void testPreconditions() {
		assertNotNull(mView);
	}

	public void testText() {
		assertEquals(resourceString, (String) mView.getText());
	}
}
