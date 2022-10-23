package pageObject;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NavigatingThroughConstructorSectionsTest extends BaseTest{

    @Test //тест успешного перехода к разделу "Начинки" конструктора
    @DisplayName("Successfully transition to the \"Ingrediens\" section of the constructor")
    public void successfulTransitionToTheIngredientsSectionConstructorTestOK() {
        mainPage.openPage();                            //загрузка основной страницы
        mainPage.clickIngredientsSection();             //переход к разделу "Начинки"
        assertEquals("Ошибка перехода к разделу \"Начинки\"", "Начинки", mainPage.getIngredientsTitle());
    }

    @Test //тест успешного перехода к разделу "Соусы" конструктора
    @DisplayName("Successfully transition to the \"Sauces\" section of the constructor")
    public void successfulTransitionToTheSaucesSectionConstructorTestOK() {
        mainPage.openPage();                             //загрузка основной страницы
        mainPage.clickSaucesSection();                   //переход к разделу "Соусы"
        assertEquals("Ошибка перехода к разделу \"Соусы\"", "Соусы", mainPage.getSaucesTitle());
    }

    @Test //тест успешного перехода к разделу "Булки" конструктора
    @DisplayName("Successfully transition to the \"Buns\" section of the constructor")
    public void successfulTransitionToTheBunsSectionConstructorTestOK() {
        mainPage.openPage();                             //загрузка основной страницы
        mainPage.clickSaucesSection();                   //переход к разделу "Соусы"
        mainPage.clickBunsSection();                     //переход к разделу "Булки"
        assertEquals("Ошибка перехода к разделу \"Булки\"", "Булки", mainPage.getBunsTitle());
    }
}
