package fr.ippon.tatami.repository;

import com.google.common.collect.Lists;
import fr.ippon.tatami.AbstractCassandraTatamiTest;
import fr.ippon.tatami.domain.status.AbstractStatus;
import fr.ippon.tatami.domain.status.Status;
import org.apache.commons.lang.StringUtils;
import org.junit.Ignore;
import org.junit.Test;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.ArrayList;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
@Ignore
public class StatusRepositoryTest extends AbstractCassandraTatamiTest {

    @Inject
    public StatusRepository statusRepository;

    @Test
    public void shouldGetAStatusRepositoryInjected() {
        assertThat(statusRepository, notNullValue());
    }

    @Test
    public void shouldCreateAStatus() {
        String login = "jdubois@ippon.fr";
        String content = "content";

        Status created = statusRepository.createStatus(login, false, null, new ArrayList<String>(),
                content, "", "", "", "48.54654, 3.87987987");
        log.info(created.getStatusId().toString());
        AbstractStatus foundStatus =  statusRepository.findStatusById(created.getStatusId().toString());
        assertThat(foundStatus, notNullValue());
    }

    @Test(expected = ValidationException.class)
    public void shouldNotCreateAStatusBecauseLoginNull() {
        String login = null;
        String content = "content";

        Status status = new Status();
        status.setContent(content);
        status.setLogin(login);

        statusRepository.createStatus(login, false, null, Lists.newArrayList(),
                content, "", "", "", null);
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldNotCreateAStatusBecauseContentNull() {
        String login = "jdubois@ippon.fr";
        String content = null;

        Status status = new Status();
        status.setContent(content);
        status.setLogin(login);

        statusRepository.createStatus(login, false, null, new ArrayList<String>(),
                content, "", "", "", null);
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldNotCreateAStatusBecauseContentEmpty() {
        String login = "jdubois@ippon.fr";
        String content = "";

        Status status = new Status();
        status.setContent(content);
        status.setLogin(login);

        statusRepository.createStatus(login, false, null, Lists.newArrayList(),
                content,StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY, null);
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldNotCreateAStatusBecauseContentTooLarge() {
        String tmp = "0123456789";
        String content = "";
        for (int i = 0; i < 410; i++) {
            content += tmp;
        }

        Status status = new Status();
        status.setContent(content);
        String login = "jdubois@ippon.fr";
        statusRepository.createStatus(login, false, null, Lists.newArrayList(),
                content, StringUtils.EMPTY,StringUtils.EMPTY, StringUtils.EMPTY, null);
    }
}
