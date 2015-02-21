import java.util.LinkedList;

public class SubmissionQueue {

	private static SubmissionQueue submissionqueue;
	private static LinkedList<Submission> queue;

	public static SubmissionQueue getSubmissionQueue() {
		if (submissionqueue == null)
			submissionqueue = new SubmissionQueue();
		return submissionqueue;
	}

	private SubmissionQueue() {
		queue = new LinkedList<Submission>();
	}

	public void add(Submission s) {
		queue.add(s);
	}

	public Submission process() {
		return queue.remove();
	}
}
