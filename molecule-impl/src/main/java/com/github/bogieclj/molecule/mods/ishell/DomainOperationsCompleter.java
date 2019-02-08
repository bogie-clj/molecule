/*
 * Copyright 2019 Vijayakumar Mohan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.bogieclj.molecule.mods.ishell;

import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import com.github.bogieclj.molecule.system.services.DomainService;

import java.util.List;
import java.util.Stack;

class DomainOperationsCompleter implements Completer{

    private DomainService domainService;
    private Stack<String> domainStack;

    DomainOperationsCompleter(DomainService domainService,Stack<String> domainStack){
        assert domainService != null;
        assert domainStack != null;
        this.domainService = domainService;
        this.domainStack = domainStack;
    }

    @Override
    public void complete(LineReader lineReader, ParsedLine parsedLine, List<Candidate> candidates) {
        assert candidates != null;

        //System.out.println(" ParsedLine "+parsedLine.word());

        String fullyQualifiedDomain = JLineInteractiveShell.getFullyQualifiedDomain(domainStack);

        List<String> operationsAt = domainService.getOperationsAt(fullyQualifiedDomain);

        if(operationsAt != null && !operationsAt.isEmpty()){


            for (String opName : operationsAt) {
                String word = parsedLine.word();
                if(opName.startsWith(word)) {
                    Candidate candidate = new Candidate(opName);
                    candidates.add(candidate);
                }
            }

        }

    }
}
