package racingcar.controller

import racingcar.model.CarModel
import racingcar.view.InputView
import camp.nextstep.edu.missionutils.Console
import racingcar.model.RandomNumber


class RacingCarController {
    private val model = CarModel()
    private val view = InputView()

    fun startRacingCarGame() {
        view.inputCarNames()
        val input = Console.readLine()
        val carNames = input.split(",")
        model.setCarNames(carNames)

        view.inputAttemptsNumber()
        val attemptsNumber = Console.readLine()
        model.setAttemptsNumber(attemptsNumber)

        for (i in 1..attemptsNumber.toInt()) {
            model.moveCar()
        }
    }

}