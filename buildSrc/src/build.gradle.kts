//Подключаем репозитории
repositories {
    jcenter()
}
//Подключаем DSL плагин, который сделает нужные классы и методы для сборки проекта на Kotlin языке
plugins {
    'kotlin-dsl'
}
//Поскольку фича еще экспериментальная, убираем предупреждение методом experimentalWarning.set(false)
kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

gradlePlugin {
    plugins {
        //Создаем сам плагин и даем ему имя
        create("my-kotlin-plugin") {
            //Устанавливаем id, по которому мы и будем его подключать в других проектах
            id = "my-kotlin-plugin"
            //Указываем запускающий класс, в котором у нас переопределен метод apply
            implementationClass = "MyKotlinPlugin"
        }
    }
}
