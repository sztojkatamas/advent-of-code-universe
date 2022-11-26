package hu.advent.of.code

import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.core.type.filter.AnnotationTypeFilter

class Application {

    fun runPuzzles(annotation: Class<out Annotation>) {

        val provider = ClassPathScanningCandidateComponentProvider(false)
        provider.addIncludeFilter(AnnotationTypeFilter(annotation))

        val defs = provider.findCandidateComponents("hu.advent.of.code")
        defs.forEach {
            (Class.forName(it.beanClassName).getConstructor().newInstance() as BaseChallenge).run()
        }
    }
}

fun main() {
    Application().runPuzzles(AdventOfCodePuzzle::class.java)
    Application().runPuzzles(RunOnlyThis::class.java)
}
