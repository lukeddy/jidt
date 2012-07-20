package infodynamics.measures.continuous.lineargaussian;

import infodynamics.measures.continuous.EntropyCalculator;
import infodynamics.utils.MatrixUtils;

/**
 * <p>Computes the differential entropy of a given set of observations, assuming that
 *  the probability distribution function for these observations is Gaussian.</p>
 *  
 * <p>
 * Usage:
 * 	<ol>
 * 		<li>Construct</li>
 *		<li>initialise()</li>
 * 		<li>setObservations(), or setVariance().</li> 
 * 		<li>computeAverageLocalOfObservations() to return the average differential
 *          entropy based on either the set variance or the variance of
 *          the supplied observations.</li>
 * 	</ol>
 * </p>
 * 
 * @see Differential entropy for Gaussian random variables defined at 
 *      {@link http://mathworld.wolfram.com/DifferentialEntropy.html}
 * @author Joseph Lizier joseph.lizier_at_gmail.com
 *
 */
public class EntropyCalculatorLinearGaussian implements EntropyCalculator {

	/**
	 * Variance of the most recently supplied observations
	 */
	protected double variance;
	
	protected boolean debug;
	
	/**
	 * Constructor
	 */
	public EntropyCalculatorLinearGaussian() {
		// Nothing to do
	}
	
	/**
	 * Initialise the calculator ready for reuse
	 */
	public void initialise() throws Exception {
		// Nothing to do
	}

	/**
	 * Provide the observations from which to compute the entropy
	 * 
	 * @param observations the observations to compute the entropy from
	 */
	public void setObservations(double[] observations) {
		variance = MatrixUtils.stdDev(observations);
		variance *= variance;
	}

	/**
	 * Set the variance of the distribution for which we will compute the
	 *  entropy.
	 * 
	 * @param variance
	 */
	public void setVariance(double variance) {
		this.variance = variance;
	}
	
	/**
	 * The entropy for a Gaussian-distribution random variable with
	 *  variance \sigma is \log_e{2*pi*e*\sigma}.
	 * Here we compute the entropy assuming that the recorded estimation of the
	 *  variance is correct (i.e. we will not make a bias correction for limited
	 *  observations here).
	 * 
	 * @return the entropy of the previously provided observations
	 */
	public double computeAverageLocalOfObservations() {
		return 0.5 * Math.log(2.0*Math.PI*Math.E*variance);
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public void setProperty(String propertyName, String propertyValue)
			throws Exception {
		// No properties to set here
	}

}