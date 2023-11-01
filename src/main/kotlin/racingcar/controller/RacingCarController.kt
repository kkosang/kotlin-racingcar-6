package racingcar.controller

import racingcar.model.CarModel
import racingcar.view.InputView
import camp.nextstep.edu.missionutils.Console
import racingcar.view.OutputView


class RacingCarController {
    private val model = CarModel()
    private val inputView = InputView()
    private val outputView = OutputView()

    fun startRacingCarGame() {
        inputView.inputCarNames()
        val input = Console.readLine()
        val carNames = input.split(",")
        model.setCarNames(carNames)

        inputView.inputAttemptsNumber()
        val attemptsNumber = Console.readLine()
        model.setAttemptsNumber(attemptsNumber)

        model.initProgressList()

        outputView.progressResult()
        for (i in 1..attemptsNumber.toInt()) {
            model.moveCar()
            printEachRacingCar(carNames)
        }

        printRacingCarWinner(carNames)
    }

    fun printEachRacingCar(carNames: List<String>) {
        for (i in carNames.indices) {
            val progress = model.getCarProgress(i)
            outputView.roundResult(carNames[i])
            outputView.makeDash((progress))
        }
        println()
    }

    fun printRacingCarWinner(carNames: List<String>) {
        val maxProgress = model.getMaxProgress()
        val winners = mutableListOf<String>()

        for (i in carNames.indices) {
            val progress = model.getCarProgress(i)
            if (progress == maxProgress) {
                winners.add(carNames[i])
            }
        }

        if (winners.size == 1) {
            outputView.singleWinner(winners[0])
        } else {
            outputView.multipleWinners(winners)
        }
    }

}