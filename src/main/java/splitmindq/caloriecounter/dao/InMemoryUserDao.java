package splitmindq.caloriecounter.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Repository;
import splitmindq.caloriecounter.model.User;

/**
 * Репозиторий для управления пользователями в памяти.
 */
@Repository
public class InMemoryUserDao {

  private final List<User> users = new ArrayList<>();

  /**
     * Возвращает список всех пользователей.
     *
     * @return список пользователей
     */
  public List<User> findAllUsers() {
    return users;
    }
  /**
     * Сохраняет пользователя в памяти.
     *
     * @param user объект пользователя для сохранения
     */

  public void saveUser(User user) {
    users.add(user);
    }
  /**
     * Ищет пользователя по email.
     *
     * @param email email пользователя
     * @return найденный пользователь или null, если не найден
     */

  public User findUserByEmail(String email) {
    return users.stream()
                .filter(element -> element.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

  /**
     * Обновляет данные пользователя.
     *
     * @param user обновленный объект пользователя
     * @return обновленный пользователь или null, если не найден
     */
  public User updateUser(User user) {
    int userIndex = IntStream.range(0, users.size())
                .filter(i -> users.get(i).getEmail().equals(user.getEmail()))
                .findFirst()
                .orElse(-1);

    if (userIndex != -1) {
      users.set(userIndex, user);
      return user;
        }
    return null;
  }

  /**
     * Удаляет пользователя по email.
     *
     * @param email email пользователя
     */
  public void deleteUser(String email) {
    var user = findUserByEmail(email);
    if (user != null) {
      users.remove(user);
        }
}

  /**
     * Возвращает список пользователей по указанному полу.
     *
     * @param gender пол пользователя (например, "male" или "female")
     * @return список пользователей с указанным полом
     */
  public List<User> findUsersByGender(String gender) {
    return users.stream()
                .filter(element -> element.getGender().equals(gender))
                .collect(Collectors.toList());
    }
}
