class Service {

    constructor() {
        this.LoadData()
    }
    async LoadData() {
        try {
            const response = await fetch('http://localhost:9000/vizsga');

            if (!response.ok) {
                const message = 'Error with Status Code: ' + response.status;
                throw new Error(message);
            }

            this.data = await response.json();
            main()
        } catch (error) {
            console.log('Error: ' + error);
        }
    }
    /**
     * Ez a függvény egy vizsga adalap tömböt add vissza
     * @returns - Egy vizsga tömmböt ad vissza
     */
    getData() {
        return this.data
    }
}

let service = new Service()

console.log(vizsgakerdesek)

function main() {
    console.log(service.getData())
    //let questions = generateQuestions()
    let vizsgakerdesek = document.getElementById("vizsgakerdesek") //DOM
    let questions = service.getData()
    for (let key in questions) {
        let kerdes = Object.assign(
            document.createElement('ul'),
            {
                id: `question-${key}`
            }
        )
        kerdes.appendChild(Object.assign(
            document.createElement('div'),
            {
                innerHTML: questions[key].question.replaceAll("\n", "<br/>")
            }
        )

        )
        for (let item of questions[key].answares) {
            let valasz = Object.assign(
                document.createElement('li'),
                {
                    innerHTML: item.answare_number + ") " + item.answare,
                }
            )
            kerdes.appendChild(valasz)
        }
        let valaszdiv = Object.assign(
            document.createElement('div'),
            {
                className: `valasz`
            }
        )
        valaszdiv.appendChild(Object.assign(
            document.createElement('span'),
            {
                innerHTML: 'Válasz: '
            }
        ))

        let valasz_input = Object.assign(
            document.createElement('input'),
            {
                type: 'text',
                name: `answare-${key}`,
            }
        )
        valasz_input.addEventListener('keypress', function (e) {
            if (e.key === 'Enter') {
                let vindex = e.target.getAttribute('name').replace("answare-", "")
                console.log(vindex)
                if (this.value === e.target.getAttribute('solution')) {
                    console.log("Jó válasz")
                    this.setAttribute('class', 'good');
                } else {
                    console.log("Rossz válasz")
                    this.setAttribute('class', 'wrong');
                }
                this.disabled = true

            }
        });
        valasz_input.setAttribute("solution", questions[key].solution)
        valaszdiv.appendChild(valasz_input)
        vizsgakerdesek.appendChild(kerdes)
        vizsgakerdesek.appendChild(valaszdiv)
    }

}

function generateQuestions() {
    let questions = []
    for (let i = 0; i < 2; i++) {
        let index = Math.round(Math.random() * 85 + 1) //1-85
        if (!(index in questions)) {
            questions[index] = service.getData()[index]
        }
    }
    for (let i = 0; i < 1; i++) {
        let index = Math.round(Math.random() * 24 + 86) // 86-110
        if (!(index in questions)) {
            questions[index] = service.getData()[index]
        }
    }
    for (let i = 0; i < 1; i++) {
        let index = Math.round(Math.random() * 25 + 111) //110-135
        if (!(index in questions)) {
            questions[index] = service.getData()[index]
        }
    }
    for (let i = 0; i < 1; i++) {
        let index = Math.round(Math.random() * 24 + 136) //136 -160
        if (!(index in questions)) {
            questions[index] = service.getData()[index]
        }
    }
    for (let i = 0; i < 3; i++) {
        let index = Math.round(Math.random() * 50 + 161) //161 -211
        if (!(index in questions)) {
            questions[index] = service.getData()[index]
        }
    }
    return questions
}

