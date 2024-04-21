package votingsystem.voting;

public class VoteExeption extends RuntimeException {
	public VoteExeption() {
		super("Already Voted");
	}
}
