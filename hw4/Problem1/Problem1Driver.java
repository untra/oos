/**
 * Problem1Driver
 * 
 * to demonstrate the Singleton SubmissionQueue for Problem 1
 * 
 * @author Samuel Volin, Cris Salazar
 */
public class Problem1Driver {

	public static void main(String[] args) {
		System.out.println("Singleton SubmissionQueue");
//		The following is not valid code because SubmissionQueue lacks a public constructor
//		queue = new SubmissionQueue();
//		The only way to get a new instance of a SubmissionQueue is through the static singleton getter
		SubmissionQueue queue = SubmissionQueue.getSubmissionQueue();
		Submission submission;
//		submissions should be added to the submissionQueue and processed out of the submissionQueue in the same FIFO order
		System.out.println("adding submissions");
		for (int i = 0; i < 10; i++) {
			submission = new Submission();
			System.out.println("adding submission " + submission.getId());
			queue.add(submission);
		}
//		If we attempt to change the same SubmissionQueue halfway through execution, we will get the same submissionqueue
		queue = SubmissionQueue.getSubmissionQueue();
		System.out.println("processing submissions");
		for (int i = 0; i < 10; i++) {
			submission = queue.process();
			System.out.println("processing submission " + submission.getId());
		}
//		If submissions were added and processed in the same fifo order, than the Singleton SubmissionQueue is a success
//		Sample output:
		
//Singleton SubmissionQueue
//adding submissions
//adding submission 425817
//adding submission 2909208
//adding submission 4460544
//adding submission 1992079
//adding submission 2788502
//adding submission 2204534
//adding submission 6803198
//adding submission 5546922
//adding submission 6019108
//adding submission 9484358
//processing submissions
//processing submission 425817
//processing submission 2909208
//processing submission 4460544
//processing submission 1992079
//processing submission 2788502
//processing submission 2204534
//processing submission 6803198
//processing submission 5546922
//processing submission 6019108
//processing submission 9484358
		 
		
	}
}
