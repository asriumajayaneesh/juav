package sw.airborne.firmwares.rotorcraft;

/*
 * TODO
import std;
import led;
import generated.airframe;
import subsystems.inh;
 */

public class Autopilot {
	
	public static final int AP_MODE_KILL = 0;
	public static final int AP_MODE_FAILSAFE      =     1;
	public static final int AP_MODE_HOME          =     2;
	public static final int AP_MODE_RATE_DIRECT    =    3;
	public static final int AP_MODE_ATTITUDE_DIRECT  =  4;
	public static final int AP_MODE_RATE_RC_CLIMB    =  5;
	public static final int AP_MODE_ATTITUDE_RC_CLIMB = 6;
	public static final int AP_MODE_ATTITUDE_CLIMB   =  7;
	public static final int AP_MODE_RATE_Z_HOLD     =   8;
	public static final int AP_MODE_ATTITUDE_Z_HOLD  =  9;
	public static final int AP_MODE_HOVER_DIRECT     =  10;
	public static final int AP_MODE_HOVER_CLIMB     =   11;
	public static final int AP_MODE_HOVER_Z_HOLD     =  12;
	public static final int AP_MODE_NAV            =    13;
	public static final int AP_MODE_RC_DIRECT       =   14;	// Safety Pilot Direct Commands for helicopter direct control
	public static final int AP_MODE_CARE_FREE_DIRECT  = 15;
	public static final int AP_MODE_FORWARD         =   16;

	public static final int MODE_MANUAL = AP_MODE_ATTITUDE_DIRECT;
	public static final int MODE_AUTO1 = AP_MODE_HOVER_Z_HOLD;
	public static final int MODE_AUTO2 = AP_MODE_NAV;
	
	public static final int THRESHOLD_1_PPRZ = Paparazzi.MIN_PPRZ / 2;
	public static final int THRESHOLD_2_PPRZ = Paparazzi.MAX_PPRZ / 2;
	
	static int autopilot_mode;
	static int autopilot_mode_auto2;
	static boolean autopilot_motors_on;
	static boolean kill_throttle;
	static boolean autopilot_rc;
	static boolean autopilot_power_switch;
	
	static boolean autopilot_ground_detected;
	static boolean autopilot_detect_ground_once;
	static int autopilot_flight_time;
	
	public static void AP_MODE_OF_PPRZ (int _rc, int _mode){
		 if      (_rc > THRESHOLD_2_PPRZ)     
	      _mode = autopilot_mode_auto2;      
	    else if (_rc > THRESHOLD_1_PPRZ)     
	      _mode = MODE_AUTO1;                
	    else                                 
	      _mode = MODE_MANUAL;               
	}
	
	
}
