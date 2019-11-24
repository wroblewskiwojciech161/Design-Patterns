package eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model;

import java.util.*;
import java.util.function.Consumer;

import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model.exceptions.CouldNotConnectException;
import eu.jpereira.trainings.designpatterns.behavioral.iterator.command.model.results.DBServerInstanceResult;

/**
 * A CommandJob is a composite of {@link Command}
 * 
 * @author jpereira
 * 
 */

//TODO: EXERCISE implement Iterable<Command> and implement the method iterator()
public class CommandJob implements Command, Iterable<Command>{

	public List<Command> commands;

	/**
	 * Create new Command Job
	 */
	public CommandJob() {
		this.commands = new ArrayList<Command>();
	}

	/**
	 * A a {@link Command} to the Job
	 * 
	 * @param command
	 *            the command
	 */
	public void addCommand(Command command) {
		this.commands.add(command);
	}

	/**
	 * Get an umodifiable collection of commands
	 * 
	 * @return
	 */
	public Collection<Command> getCommands() {
		return Collections.unmodifiableCollection(commands);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.behavioral.command.model.command
	 * .Command#execute()
	 */

	@Override
	public void execute() throws CouldNotConnectException {
		// for each command, execute it.
		// Can store the result
		for (Command command : this.commands) {
			command.execute();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.behavioral.command.model.command
	 * .Command#getResult()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public DBServerInstanceResult getResult() {
		// Can store the result
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Iterator<Command> iterator() {
		return new CommandsIterator();
	}

	@SuppressWarnings("rawtypes")
	private class CommandsIterator implements Iterator {

	    private int position = -1;

        @Override
        public boolean hasNext() {
            if(position < commands.size()-1) return true;
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()) {
                position++;
                return commands.get(position);
            }
            else
                return null;
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer action) {

        }
    }
}