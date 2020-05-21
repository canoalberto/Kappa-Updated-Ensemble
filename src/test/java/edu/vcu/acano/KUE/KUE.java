package edu.vcu.acano.KUE;

import com.yahoo.labs.samoa.instances.Instance;

import moa.classifiers.Classifier;
import moa.core.InstanceExample;
import moa.core.TimingUtils;
import moa.evaluation.WindowClassificationPerformanceEvaluator;
import moa.streams.generators.RandomRBFGenerator;

public class KUE {

	public void run(int maximumNumberInstances)
	{
		// Generator as a stream
		RandomRBFGenerator stream = new RandomRBFGenerator();
		stream.prepareForUse();

		// Setup classifier
		Classifier learner = new moa.classifiers.meta.KUE();
		learner.setModelContext(stream.getHeader());
		learner.prepareForUse();

		int numberInstances = 0;

		long evaluateStartTime = TimingUtils.getNanoCPUTimeOfCurrentThread();
		
		//BasicClassificationPerformanceEvaluator evaluator = new BasicClassificationPerformanceEvaluator();
		//PrequentialClassificationPerformanceEvaluator evaluator = new PrequentialClassificationPerformanceEvaluator();
		WindowClassificationPerformanceEvaluator evaluator = new WindowClassificationPerformanceEvaluator();

		while (stream.hasMoreInstances() && numberInstances < maximumNumberInstances)
		{
			InstanceExample example = stream.nextInstance();
			Instance trainInst = example.getData();
			
			evaluator.addResult(example, learner.getVotesForInstance(trainInst));
			// test-then-train instance by instance
			learner.trainOnInstance(trainInst);
			
			numberInstances++;
		}
		
		double time = TimingUtils.nanoTimeToSeconds(TimingUtils.getNanoCPUTimeOfCurrentThread() - evaluateStartTime);
		
		System.out.println(numberInstances + " instances processed with " + evaluator.getFractionCorrectlyClassified()*100 + "% accuracy in " + time + " seconds.");
	}

	public static void main(String[] args) throws Exception
	{
		KUE exp = new KUE();
		exp.run(100000);
	}
}