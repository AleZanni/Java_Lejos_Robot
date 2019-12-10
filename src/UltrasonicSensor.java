import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class UltrasonicSensor {

private static EV3UltrasonicSensor us2 = new EV3UltrasonicSensor(SensorPort.S2);

float distanceValue = 0;

public static void ultraSonicDetection(float distanceValue) {
		final SampleProvider sp = us2.getDistanceMode();

	        final int iteration_threshold = 100;
	        for(int i = 0; i <= iteration_threshold; i++) {

	        float [] sample = new float[sp.sampleSize()];
	            sp.fetchSample(sample, 0);
	            distanceValue = (float)sample[0];
	            MovementController.movingForward();
	if (distanceValue<=0.3) {
	MovementController.stopMoving();
	Motor.B.rotate(360);
	MovementController.movingForward();
	Delay.msDelay(3000);
	break;
	}


	Delay.msDelay(800);
	        }
	
}


}