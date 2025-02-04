package seedu.times.logic.parser;

import static seedu.times.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.times.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.times.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.times.logic.commands.FindTagCommand;
import seedu.times.model.person.predicates.TagsContainsKeywordsPredicate;

public class FindTagCommandParserTest {
    private FindTagCommandParser parser = new FindTagCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindTagCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindTagCommand() {
        // no leading and trailing whitespaces
        FindTagCommand expectedFindTagCommand =
                new FindTagCommand(new TagsContainsKeywordsPredicate(Arrays.asList("Maths", "Physics")));
        assertParseSuccess(parser, "Maths, Physics", expectedFindTagCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n Maths, \n \t Physics  \t", expectedFindTagCommand);
    }
}
