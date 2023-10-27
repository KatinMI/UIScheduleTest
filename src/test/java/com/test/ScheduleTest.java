package com.test;

import com.test.model.Lecture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Test class
 */
public class ScheduleTest extends BaseTest{
    private final static String URL = "https://sd.mstuca1.ru/";
    private MainPage mainPage;

    @BeforeEach
    public void initMainPage(){
        mainPage = new MainPage(URL);
    }

    /**
     * The method verifies the correctness of the read lecture types in the schedule
     * @param type - type of lecture
     * @param day - the day on which the lecture was held
     * @param numOfLecture - which lecture is on the schedule
     */
    @ParameterizedTest
    @CsvSource({"'Лекция', 29, 4","'Практическое занятие', 29, 5","'Лабораторная работа', 30, 3"})
    public void checkLectureType(String type, int day, int numOfLecture){
    Assertions.assertEquals(type,mainPage.clickOnLink().openFullSchedule().getOldLecture(day,numOfLecture).getType());
    }

    /**
     * The method verifies the correctness of the read lector name in the schedule
     * @param lector - lector name
     * @param day - the day on which the lecture was held
     * @param numOfLecture - which lecture is on the schedule
     */
    @ParameterizedTest
    @CsvSource({"'Емельянов В.Е.', 29, 3", "'Антонов А.А.', 30, 3", "'Уляева Г.Г.', 29, 5"})
    public void checkLectureLector(String lector, int day, int numOfLecture){
        Assertions.assertEquals(lector, mainPage.clickOnLink().openFullSchedule().getOldLecture(day,numOfLecture).getLecturer());
    }

    /**
     * The method verifies the correctness of the read lecture name in the schedule
     * @param name - name of lecture
     * @param day - the day on which the lecture was held
     * @param numOfLecture - which lecture is on the schedule
     */
    @ParameterizedTest
    @CsvSource({"'Информационная безопасность телекоммуникационных систем', 29, 3",
            "'Информационная безопасность и защита информации в интегрированных телекоммуникационных и корпоративных сетях транспорта', 29, 4",
            "'Физическая культура: по выбору обучающихся (элективная дисциплина)', 29, 5"})
    public void checkLectureName(String name, int day, int numOfLecture){

        Assertions.assertEquals(name, mainPage.clickOnLink().openFullSchedule().getOldLecture(day,numOfLecture).getName());
    }

    /**
     * The method verifies the correctness of the read lectures auditorium in the schedule
     * @param auditorium - lectures auditorium
     * @param day - the day on which the lecture was held
     * @param numOfLecture - which lecture is on the schedule
     */
    @ParameterizedTest
    @CsvSource({"'5-308', 29, 3","'5-311', 29, 4","'Спортзал 4', 29, 5"})
    public void checkLectureAuditorium(String auditorium, int day, int numOfLecture){
        Assertions.assertEquals(auditorium,mainPage.clickOnLink().openFullSchedule().getOldLecture(day,numOfLecture).getAuditorium());
    }

    /**
     * The method checks the correctness of current lectures in the schedule
     */
    @Test
    public void checkActualLecture(){
    Assertions.assertEquals(new Lecture("Криптографические методы защиты информации","Антонов А.А.","5-307","Лабораторная работа"),
            mainPage.clickOnLink().openFullSchedule().getLecture(2,3));
    }

    /**
     * The method checks the correctness of the lectures for the next one in the schedule
     */
    @Test
    public void checkNextDaySchedule(){
        Assertions.assertEquals("Антонов А.А.",mainPage.clickOnLink().openScheduleOnOneDay().nextDay().getLecture(1).getLecturer());
    }

    /**
     * The method checks the correctness of the lectures for the previous day in the schedule
     */
    @Test
    public void checkPrevDaySchedule(){
        Assertions.assertEquals("Пригонюк Н.Д.",mainPage.clickOnLink().openScheduleOnOneDay().prevDay().getLecture(1).getLecturer());
    }

    /**
     * The method checks the correctness of the lectures for the concrete day in the schedule
     */
    @Test
    public void checkRandomDaySchedule(){
    Assertions.assertEquals("Степаненко Е.В.",mainPage.clickOnLink().openScheduleOnOneDay().getConcretePage("2023-10-23").getLecture(2).getLecturer());
    }
}
