import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void testSimple() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Assertions.assertFalse(simpleTask.matches("Приехать"));
        Assertions.assertTrue(simpleTask.matches("Позвонить"));
        Assertions.assertTrue(simpleTask.matches(""));
    }

    @Test
    public void testMeeting() {
        Meeting meeting = new Meeting(1, "Почта", "Проект", "Завтра");
        Assertions.assertTrue(meeting.matches("Проект"));
        Assertions.assertFalse(meeting.matches("Вчера"));
        Assertions.assertTrue(meeting.matches(""));
    }

    @Test
    public void testEpic() {
        String[] subtasks = {"Прийти", "Отдать", "Взять"};
        Epic epic = new Epic(1, subtasks);
        Assertions.assertTrue(epic.matches("Отдать"));
        Assertions.assertFalse(epic.matches("отдать"));
        Assertions.assertFalse(epic.matches("Продукты "));
        Assertions.assertTrue(epic.matches(""));
    }
}
