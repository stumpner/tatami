package fr.ippon.tatami.service;

import fr.ippon.tatami.domain.UserStatusStat;
import fr.ippon.tatami.repository.DaylineRepository;
import fr.ippon.tatami.security.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Service
public class StatsService {

    @Inject
    private DaylineRepository daylineRepository;

    static final SimpleDateFormat DAYLINE_KEY_FORMAT = new SimpleDateFormat("ddMMyyyy");

    /**
     * The dayline contains a day's status.
     *
     * @return a status list
     */
    public Collection<UserStatusStat> getDayline() {
        Date today = new Date();
        return getDayline(today);
    }

    /**
     * The dayline contains a day's status.
     *
     * @param date the day to retrieve the status of
     * @return a status list
     */
    public Collection<UserStatusStat> getDayline(Date date) {
        if (date == null) {
            date = new Date();
        }
        String day = DAYLINE_KEY_FORMAT.format(date);
        return daylineRepository.getDayline(SecurityUtils.getCurrentUserDomain(), day);
    }
}