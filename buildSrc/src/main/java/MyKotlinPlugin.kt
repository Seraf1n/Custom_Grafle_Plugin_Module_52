import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class MyKotlinPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        println("Hello from kotlin plugin")
        //Имя таски
        val myTask = "MyTask"
        //Добавляем таску в TaskContainer
        project.tasks.create(myTask) {
            //Задаем группу, чтобы найти нашу таску в отдельной папке, а не в общей папке other
            group = "MyAwesomeTasks"
            //Задаем путь и имя создаваемого файла
            val path = "${project.projectDir.path}/generated_file.txt"
            //Создаем саму работу
            doLast {
                //Создаем файл и пишем в него строку
                File(path).apply {
                    writeText("Привет, я твой созданный файл!\nСоздан в: ${SimpleDateFormat("HH:mm:ss").format(
                        Date()
                    )}")
                }
                //Выводим в консоль, что файл создан
                println("File created!")
                //Выводим путь к файлу (будет как ссылка)
                println(path)
            }
        }
    }
}