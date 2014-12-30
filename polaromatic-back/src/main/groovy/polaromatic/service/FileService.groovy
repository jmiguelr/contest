package polaromatic.service

import groovy.util.logging.Slf4j
import org.apache.commons.lang.RandomStringUtils
import org.springframework.stereotype.Service
import polaromatic.domain.Photo

import java.nio.file.Paths

@Slf4j
@Service
class FileService {

    Photo preprocessFile(File file) {
        String filename = RandomStringUtils.randomAlphanumeric(10)

        String outputPath = File.createTempDir()
        String outputFilename = "${new Date().time}_${filename}.png"
        def outputFile = Paths.get(outputPath, outputFilename)

        return new Photo(input: file.absolutePath, output: outputFile)
    }

}