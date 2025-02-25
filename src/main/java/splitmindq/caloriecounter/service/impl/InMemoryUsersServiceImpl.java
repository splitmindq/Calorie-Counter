package splitmindq.caloriecounter.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import splitmindq.caloriecounter.dao.InMemoryUserDao;
import splitmindq.caloriecounter.model.User;
import splitmindq.caloriecounter.service.UserService;

/**
 * Реализация сервиса для работы с пользователями, использующая данные, хранящиеся в памяти.
 * Реализует интерфейс {@link UserService} для управления пользователями.
 */
@Service
@AllArgsConstructor
public class InMemoryUsersServiceImpl implements UserService {

  /**
     * Репозиторий для работы с данными пользователей в памяти.
     */
  private final InMemoryUserDao repository;

  /**
     * Находит всех пользователей.
     *
     * @return список всех пользователей.
     */
  @Override
    public List<User> findAllUsers() {
    return repository.findAllUsers();
    }

  /**
     * Сохраняет пользователя.
     *
     * @param user объект пользователя, который необходимо сохранить.
     */
  @Override
    public void saveUser(User user) {
    repository.saveUser(user);
    }

  /**
     * Находит пользователя по его адресу электронной почты.
     *
     * @param email электронная почта пользователя.
     * @return пользователь с указанным адресом электронной почты.
     */
  @Override
    public User findUserByEmail(String email) {
    return repository.findUserByEmail(email);
    }

  /**
     * Обновляет информацию о пользователе.
     *
     * @param user объект пользователя с обновленными данными.
     * @return обновленный объект пользователя.
     */
  @Override
    public User updateUser(User user) {
    return repository.updateUser(user);
    }

  /**
     * Удаляет пользователя по адресу электронной почты.
     *
     * @param email электронная почта пользователя, которого необходимо удалить.
     */
  @Override
    public void deleteUser(String email) {
    repository.deleteUser(email);
    }

  /**
     * Находит пользователей по полу.
     *
     * @param gender пол пользователей (может быть null, если не фильтровать по полу).
     * @return список пользователей, соответствующих указанному полу.
     */
  @Override
    public List<User> findUsersByGender(String gender) {
    return repository.findUsersByGender(gender);
    }
}
