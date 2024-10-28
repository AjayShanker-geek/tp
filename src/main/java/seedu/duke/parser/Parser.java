package seedu.duke.parser;

import java.util.logging.Level;
import java.util.logging.Logger;

import seedu.duke.commands.Command;
import seedu.duke.data.state.State;

public class Parser {
    private static final Logger LOGGER = Logger.getLogger("Parser");

    static {
        LOGGER.setLevel(Level.SEVERE);
    }

    public Command parseCommand(String line, State state){
        String[] parts = line.split(" ");

        switch(parts[0]){
        case "todo":
            try{
                return new AddTodoParser().execute(line, state);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The input cannot be empty");
                LOGGER.log(Level.WARNING, "Todo Command Error: Non-Numerical Error");
            }
            break;

        case "deadline":
            try{
                return new AddDeadlineParser().execute(line, state);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The input cannot be empty");
                LOGGER.log(Level.WARNING, "Deadline Command Error: Non-Numerical Error");

            }
            break;

        case "repeat":
            try{
                return new AddRepeatParser().execute(line, state);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The input cannot be empty");
                LOGGER.log(Level.WARNING, "Repeat Command Error: Non-Numerical Error");
            }
            break;

        case "add":
            try{
                return new AddParser().execute(line, state);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The input cannot be empty");
                LOGGER.log(Level.WARNING, "Add Command Error: Empty field");
            }
            break;

        case "list":
            return new ListParser().execute(line, state);

        case "delete":
            try{
                return new DeleteParser().execute(line, state);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The input cannot be empty");
                LOGGER.log(Level.WARNING, "Delete Command Error: Non-Numerical Error");
            }
            break;

        case "select":
            try{
                return new SelectParser().execute(line, state);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The input cannot be empty");
                LOGGER.log(Level.WARNING, "Select Command Error: Non-Numerical Error");
            }
            break;

        case "mark":
            try{
                return new MarkParser().execute(line, state);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The input cannot be empty");
                LOGGER.log(Level.WARNING, "Mark Command Error: Non-Numerical Error");
            }
            break;

        case "unmark":
            try{
                return new UnmarkParser().execute(line, state);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The input cannot be empty");
                LOGGER.log(Level.WARNING, "Unmark Command Error: Non-Numerical Error");
            }
            break;

        case "back":
            return new BackParser().execute(line, state);

        case "find":
            try{
                return new FindParser().execute(line, state);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The input cannot be empty");
                LOGGER.log(Level.WARNING, "Find Command Error: Non-Numerical Error");
            }
            break;

        case "exit":
            return new ExitParser().execute(line, state);

        default:
            LOGGER.log(Level.WARNING, "The user did not enter a valid command");
            return null;
        }
        return null;
    }
}
