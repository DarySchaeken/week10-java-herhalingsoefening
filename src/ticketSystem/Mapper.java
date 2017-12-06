package ticketSystem;

public interface Mapper<T> {
	public abstract T map(String[] dataInput);
}
