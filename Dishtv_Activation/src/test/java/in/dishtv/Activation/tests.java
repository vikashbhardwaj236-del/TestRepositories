package in.dishtv.Activation;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class tests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testone();
	}

	public static void testone() {

		try {

			Desktop.getDesktop().open(new File("C:\\RunEXE-Complaint-FR-117\\ComplaintGenration.jar"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
