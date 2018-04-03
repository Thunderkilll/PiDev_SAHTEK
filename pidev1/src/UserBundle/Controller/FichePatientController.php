<?php

namespace UserBundle\Controller;

use UserBundle\Entity\FichePatient;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

/**
 * Fichepatient controller.
 *
 */
class FichePatientController extends Controller
{
    /**
     * Lists all fichePatient entities.
     *
     */
    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $fichePatients = $em->getRepository('UserBundle:FichePatient')->findAll();

        return $this->render('fichepatient/index.html.twig', array(
            'fichePatients' => $fichePatients,
        ));
    }

    /**
     * Creates a new fichePatient entity.
     *
     */
    public function newAction(Request $request)
    {
        $fichePatient = new Fichepatient();
        $form = $this->createForm('UserBundle\Form\FichePatientType', $fichePatient);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($fichePatient);
            $em->flush();

            return $this->redirectToRoute('fiche_index');
        }

        return $this->render('fichepatient/new.html.twig', array(
            'fichePatient' => $fichePatient,
            'form' => $form->createView(),
        ));
    }

    /**
     * Finds and displays a fichePatient entity.
     *
     */
    public function showAction(FichePatient $fichePatient)
    {
        $deleteForm = $this->createDeleteForm($fichePatient);

        return $this->render('fichepatient/show.html.twig', array(
            'fichePatient' => $fichePatient,
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Displays a form to edit an existing fichePatient entity.
     *
     */
    public function editAction(Request $request, FichePatient $fichePatient)
    {
        $deleteForm = $this->createDeleteForm($fichePatient);
        $editForm = $this->createForm('UserBundle\Form\FichePatientType', $fichePatient);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('fiche_edit', array('id_fiche' => $fichePatient->getIdFiche()));
        }

        return $this->render('fichepatient/edit.html.twig', array(
            'fichePatient' => $fichePatient,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Deletes a fichePatient entity.
     *
     */
    public function deleteAction(Request $request, FichePatient $fichePatient)
    {
        $form = $this->createDeleteForm($fichePatient);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->remove($fichePatient);
            $em->flush();
        }

        return $this->redirectToRoute('fiche_index');
    }

    /**
     * Creates a form to delete a fichePatient entity.
     *
     * @param FichePatient $fichePatient The fichePatient entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm(FichePatient $fichePatient)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('fiche_delete', array('id_fiche' => $fichePatient->getIdFiche())))
            ->setMethod('DELETE')
            ->getForm()
        ;
    }
}
