package edu.zut.wi.planttactic.classes


class PotDevice() {

    var id: Int = 0
    var name: String = ""
    var imageName: String = ""

    constructor(name: String, imageName: String) : this() {
        this.name = name
        this.imageName = imageName
    }

}