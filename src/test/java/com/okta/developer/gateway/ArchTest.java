package com.okta.developer.gateway;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.okta.developer.gateway");

        noClasses()
            .that()
                .resideInAnyPackage("..service..")
            .or()
                .resideInAnyPackage("..repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.okta.developer.gateway.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }


    @Test
    void interview() {
        System.out.println(2);
        System.out.println(3);
        for (int m = 3; m <= 100;) {
           if (isPrimeNumber1(m)){
               System.out.println(m);
           }
            m=m+2;
        }

    }


    public static boolean isPrimeNumber1(int n) {
        if (n % 2 ==0 || n % 3==0 ) {
            return false;
        }
        int f=0;
        for (int i = 3; i <= n / 2; i++) {
            if (n % i == 0) {
               f++;
            }
            if (f>1 ){
                return false;
            }
        }
        return true;
    }
}
